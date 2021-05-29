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
          class="radio-change"
          id="radio-change"
          :value="option.hallType.type"
          :name="type - hall"
          @change="radio_listener($event)"
          v-model="pick"
          checked="checked"
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
          @change="slider_listener()"
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
      curent_type: "",
    };
  },
  methods: {
    draw_rectangles(colors) {
      //console.log(colors);
      var c = document.getElementById("myCanvas");
      var ctx = c.getContext("2d");
      var img = document.getElementById("MyImage");
      ctx.drawImage(img, 0, 0);
      var canvas = document.getElementById("myCanvas");
      var context = canvas.getContext("2d");

      var positions = [];

      var counter = 0;

      this.img_positions_data.forEach((position) => {
        positions.push(position);
        var start_x = position[0];
        var start_y = position[1];
        var finish_x = position[2];
        var finish_y = position[3];
        context.beginPath();
        context.rect(start_x, start_y, finish_x, finish_y);
        if (colors.length == 0 || counter >= colors.length) {
          context.fillStyle = "#E6E7E8";
        } else {
          context.fillStyle = colors[counter];
        }
        context.fill();
        counter += 1;
      });

      canvas.onmousemove = function(e) {
        // important: correct mouse position:
        var counter = 0;
        var rect = this.getBoundingClientRect(),
          x = e.clientX - rect.left,
          y = e.clientY - rect.top;
        var color_map = {
          "#B5FBDD": "#00CF91",
          "#FF756B": "#E20338",
          "#E6E7E8": "#BCBEC0",
        };
        //ctx.clearRect(0, 0, canvas.width, canvas.height); // for demo

        positions.forEach((position) => {
          var start_x = position[0];
          var start_y = position[1];
          var finish_x = position[2];
          var finish_y = position[3];
          ctx.beginPath();
          ctx.rect(start_x, start_y, finish_x, finish_y);
          if (colors.length == 0 || counter >= colors.length) {
            ctx.fillStyle = ctx.isPointInPath(x, y) ? "#BCBEC0" : "#E6E7E8";
          } else {
            ctx.fillStyle = ctx.isPointInPath(x, y)
              ? color_map[colors[counter]]
              : colors[counter];
          }
          ctx.fill();
          counter += 1;
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
      this.curent_type = optionText;
      this.set_time(optionText);
    },

    get_hole_state(time) {
      var result = [];
      this.hallSource.forEach((element) => {
        if (element.hallType.type == this.curent_type) {
          var hall_busy = false;
          this.reservationSource.forEach((reservation) => {
            if (element.id == reservation.sportHall.id) {
              if (reservation.timeFrom != time + ":00") {
                hall_busy = true;
              }
            }
          });
          if (hall_busy) {
            //red
            result.push("#FF756B");
          } else {
            //green
            result.push("#B5FBDD");
          }
        } else {
          //gray
          result.push("#E6E7E8");
        }
      });
      return result;
    },

    slider_listener() {
      var sliderDiv = document.getElementById("myRange");
      var curentTime = document.getElementById("curent-time");
      var starttTime = document.getElementById("start-time");
      var new_time =
        parseInt(starttTime.innerText.split(":")[0]) +
        parseInt(sliderDiv.value) -
        1;
      var time = ("00" + new_time + ":00").slice(-5);
      curentTime.innerText = time;
      var colors = this.get_hole_state(time);
      this.draw_rectangles(colors);
    },
  },
  mounted() {
    this.$nextTick(this.draw_rectangles([]));
    //this.$nextTick(this.slider_listener());
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
