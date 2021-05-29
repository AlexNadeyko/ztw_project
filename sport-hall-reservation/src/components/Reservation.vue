<template>
  <h1>Reservation</h1>

  <div class="container">
    <div class="input-container">
      <h4>Select a dyscipline</h4>
      <div
        class="check-element"
        v-for="(option, index) in this.find_halls_out_dup"
        :key="index"
      >
        <input
          type="radio"
          :id="index"
          :value="option.hallType.type"
          :name="'option-selected'"
          @change="radio_listener($event)"
          v-model="option.value"
        />
        <label :for="index">{{ option.hallType.type }}</label>
      </div>
    </div>
    <div class="reservation-container">
      <img id="MyImage" src="../assets/PlanFloor.png" />
      <canvas id="myCanvas" width="1180" height="700">
        Your browser does not support the HTML5 canvas tag.
      </canvas>

      <div class="time-container">
        <p id="curent-time">08:00</p>
        <p class="time-element" id="start-time">08:00</p>
        <input
          type="range"
          min="1"
          max="12"
          value="1"
          class="slider"
          id="myRange"
        />
        <p class="time-element" id="finish-time">20:00</p>
      </div>
    </div>
  </div>
</template>

<script>
//          @change="this.slider_listener($value)"

export default {
  name: "reservations-table",
  props: {
    reservationSource: Array,
    hallSource: Array,
  },
  data() {
    return {
      converted_reservation: Array,
      PlanFloor: require("../assets/PlanFloor.png"),
      img_positions_data: [
        [9, 8, 156, 197],
        [173, 8, 152, 197],
        [334, 8, 154, 197],
        [496, 8, 187, 197],
        [691, 8, 224, 197],
        [923, 8, 221, 197],
        [9, 326, 340, 314],
        [357, 326, 378, 314],
        [743, 326, 401, 314],
      ],
    };
  },
  methods: {
    draw_rectangles() {
      var c = document.getElementById("myCanvas");
      var ctx = c.getContext("2d");
      var img = document.getElementById("MyImage");
      ctx.drawImage(img, 0, 0);
      var canvas = document.getElementById("myCanvas");
      var context = canvas.getContext("2d");

      var positions = [];

      this.img_positions_data.forEach((position) => {
        positions.push(position);
        var start_x = position[0];
        var start_y = position[1];
        var finish_x = position[2];
        var finish_y = position[3];
        context.beginPath();
        context.rect(start_x, start_y, finish_x, finish_y);
        context.fillStyle = "yellow";
        context.fill();
      });

      canvas.onmousemove = function(e) {
        // important: correct mouse position:
        var rect = this.getBoundingClientRect(),
          x = e.clientX - rect.left,
          y = e.clientY - rect.top;

        //ctx.clearRect(0, 0, canvas.width, canvas.height); // for demo
        positions.forEach((position) => {
          var start_x = position[0];
          var start_y = position[1];
          var finish_x = position[2];
          var finish_y = position[3];
          ctx.beginPath();
          ctx.rect(start_x, start_y, finish_x, finish_y);
          ctx.fillStyle = ctx.isPointInPath(x, y) ? "red" : "yellow";
          ctx.fill();
        });
      };
    },
    set_time(optionText) {
      var start_time = "";
      var finish_time = "";

      this.hallSource.forEach((element) => {
        if (element.hallType.type == optionText) {
          start_time = element.work_from;
          finish_time = element.work_to;
        }
      });

      var startTime = document.getElementById("start-time");
      var finishTime = document.getElementById("finish-time");
      startTime.innerText = start_time.substring(0, 5);
      finishTime.innerText = finish_time.substring(0, 5);
    },

    radio_listener(event) {
      var optionText = event.target.value;
      this.set_time(optionText);
    },

    slider_listener() {
      var sliderDiv = document.getElementById("myRange");
      sliderDiv.onchange = function() {
        var curentTime = document.getElementById("curent-time");
        var starttTime = document.getElementById("start-time");

        var new_time =
          parseInt(starttTime.innerText.split(":")[0]) +
          parseInt(this.value) -
          1;
        curentTime.innerText = ("00" + new_time + ":00").slice(-5);
      };
    },
  },
  mounted() {
    this.$nextTick(this.draw_rectangles());
    this.$nextTick(this.slider_listener());
  },
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
          time_list.splice(-1, 1);
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
  },
};
</script>
<style>
.check-element {
  margin-bottom: 0.5em;
}

.input-container {
  display: inline-block;
  text-align: left;
  font-size: 1.5em;
  /* border: solid 1px #ccc; */
  margin-right: 2em;
}
.reservation-container {
  display: inline;
  vertical-align: top;
}

.time-container {
  display: inline-block;
  width: 40%;
}

.time-element {
  display: inline;
}

img {
  height: 30em;
  width: 75%;
  display: none;
}
.container {
  /* display: inline-block;  */
  display: inline-block;
}
canvas {
  height: 30em;
  width: 75%;
}

.slidecontainer {
  width: 100%;
}

.slider {
  -webkit-appearance: none;
  width: 60%;
  height: 25px;
  background: #d3d3d3;
  outline: none;
  opacity: 0.7;
  -webkit-transition: 0.2s;
  transition: opacity 0.2s;
  margin-left: 1em;
  margin-right: 1em;
}

.slider:hover {
  opacity: 1.5;
}

.slider::-webkit-slider-thumb {
  -webkit-appearance: none;
  appearance: none;
  width: 30px;
  height: 30px;
  background: #80b3a0;
  cursor: pointer;
}

.slider::-moz-range-thumb {
  width: 25px;
  height: 25px;
  background: #80b3a0;
  cursor: pointer;
}
</style>
