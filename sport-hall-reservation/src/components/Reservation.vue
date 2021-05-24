<template>
  <h1>Reservation</h1>

  <div class="container">
    <table>
      <th>
        <div id="reservations-table">
          <div class="input-container">
            <h4>Select a dyscipline</h4>
            <div
              v-for="(option, index) in this.find_halls_out_dup"
              :key="index"
            >
              <input
                type="radio"
                :id="index"
                :value="option.hallType.type"
                :name="'option-selected'"
                v-model="option.value"
              />
              <label :for="index">{{ option.hallType.type }}</label>
            </div>
          </div>
        </div>
      </th>
      <th>
        <div class="reservation-container">
          <table>
            <tbody>
              <th>Court</th>
              <th v-for="(time, index) in this.get_only_time" :key="index">
                {{ time }}
              </th>
              <th>Court</th>

              <tr
                v-for="reservation in this.convert_reservations"
                :key="reservation.id"
              >
                <td>{{ reservation.id_num + 1 }}</td>

                <td v-for="(time, index) in reservation.time" :key="index">
                  <input
                    type="checkbox"
                    id="time_checkbox"
                    name="time_checkbox"
                    value="Bike"
                  />
                </td>
                <td>{{ reservation.id_num + 1 }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </th>
    </table>
  </div>
</template>
<script>
export default {
  name: "reservations-table",
  props: {
    reservationSource: Array,
    hallSource: Array,
  },
  data() {
    return {
      converted_reservation: Array,
    };
  },
  methods: {},
  computed: {
    find_halls_out_dup() {
      var halls_dup = [];
      var id_halls_dup = [];
      this.hallSource.forEach((element) => {
        if (!id_halls_dup.includes(element.hallType.type)) {
          id_halls_dup.push(element.hallType.type);
          halls_dup.push(element);
        }
      });
      return halls_dup;
    },
    convert_reservations() {
      const type = "Tennis";

      var converted_res_list = [];
      var id_counter = 0;
      this.reservationSource.forEach((element) => {
        if (element.sportHall.hallType.type == type) {
          console.log(element.sportHall.hallType.type);
          var time_list = [];
          var from = element.sportHall.work_from.split(":");
          var to = element.sportHall.work_to.split(":");
          var time_hours = parseInt(to, 10) - parseInt(from, 10);
          for (var i = 0; i < time_hours; i++) {
            time_list.push((parseInt(from, 10) + i).toString());
          }
          time_list.splice(-1,1)
          converted_res_list.push({
            id_sportHall: element.sportHall.id,
            id_num: id_counter,
            time: time_list,
            id_type: element.sportHall.hallType.type,
          });
          id_counter += 1;
        }
      });
      return converted_res_list;
    },
    get_only_time() {
      const type = "Tennis";

      var converted_time_list = [];
      this.reservationSource.forEach((element) => {
        if (element.sportHall.hallType.type == type) {
          console.log(element.sportHall.hallType.type);
          var time_list = [];
          var from = element.sportHall.work_from.split(":");
          var to = element.sportHall.work_to.split(":");
          var time_hours = parseInt(to, 10) - parseInt(from, 10);
          for (var i = 0; i < time_hours; i++) {
            time_list.push((parseInt(from, 10) + i).toString());
          }
          converted_time_list.push(time_list);
        }
      });
      console.log(this.reservationSource)
      for (var i = 0; i < converted_time_list[0].length; i++) {
        if(i != converted_time_list[0].length -1)
          converted_time_list[0][i] = converted_time_list[0][i] + " - "+ converted_time_list[0][i+1]
      }
      console.log(converted_time_list);
      converted_time_list[0].splice(-1,1)
      return converted_time_list[0];
    },
  },
};
</script>
<style>
input[type="radio"] {
  width: 1.5em;
  height: 1.5em;
}
input[type="radio"]:checked:after {
  width: 1.5em;
  height: 1.5em;
  border-radius: 1.5em;

  background-color: #8a8a8a;
  content: "";
  display: inline-block;
  border: 2px solid white;
}
.input-container {
  text-align: left;
  font-size: 1.5em;
  border: solid 1px #ccc;
}
.reservation-container {
  border: solid 1px #ccc;
  width: 100%;
}
table {
  border: solid 1px #ccc;
  width: 100%;
}
/* .container{
    display: inline-block; 
} */
</style>