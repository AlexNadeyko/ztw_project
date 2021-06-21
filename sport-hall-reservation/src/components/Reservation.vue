<template>
  <div class="navbar-background"></div>

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

        <input
          type="date"
          class="date-check"
          id="date-check"
          name="date-check"
          value="2018-07-22"
          min="2018-01-01"
          max="2018-12-31"
          @change="date_listener()"
        />

        <button class="button turquoise" v-on:click="make_reservation">
          <span>✓</span>Zarezerwuj
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
const SERVER_URL = "http://localhost:8080";
const instance = axios.create({
  baseURL: SERVER_URL,
  timeout: 2000,
});
export default {
  name: "reservations-table",
  // props: {
  //   reservationSource: Array,
  //   hallSource: Array,
  // },
  data() {
    return {
      reservationSource: [],
      hallSource: [],
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
      copy_hallSource: [
        [1, "Basketball"],
        [2, "Tennis"],
        [3, "Football"],
        [4, "Volleyball"],
        [5, "Basketball"],
        [6, "Tennis"],
        [7, "Tennis"],
        [8, "Tennis"],
        [9, "Football"],
      ],
      choosen: -1,
      reservation: {
        id_user: 1,
        id_hall: -1,
        reservation_date: "",
        time_from: "",
        time_to: "",
        full_price: 0,
        is_paid: 1,
        description: "",
      },
      user: {
        name: "Hleb",
        surname: "Liaonik",
        email: "248795@student.pwr.edu.pl",
      },
    };
  },
  methods: {
    async getReservations() {
      try {
        const response = await fetch("http://localhost:8080/get/reservations");
        const data = await response.json();
        this.reservationSource = data;
      } catch (error) {
        console.error(error);
      }
    },

    async getHalls() {
      try {
        const response = await fetch("http://localhost:8080/get/halls");
        const data = await response.json();
        this.hallSource = data;
      } catch (error) {
        console.error(error);
      }
    },
    draw_rectangles(colors) {
      //console.log(colors);
      var c = document.getElementById("myCanvas");
      var ctx = c.getContext("2d");
      var img = document.getElementById("MyImage");
      ctx.drawImage(img, 0, 0);
      var canvas = document.getElementById("myCanvas");
      var context = canvas.getContext("2d");

      //ctx.clearRect(0, 0, canvas.width, canvas.height);

      var positions = [];

      var counter = 0;

      var hall_data = this.copy_hallSource;

      this.img_positions_data.forEach((position) => {
        positions.push(position);
        this.choosen = -1;
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
        context.fillStyle = "black";
        ctx.font = "30px Arial";
        ctx.textAlign = "center";
        ctx.fillText(
          hall_data[counter][1],
          start_x + finish_x / 2,
          start_y + finish_y / 2 - 40
        );
        ctx.fillText(
          hall_data[counter][0],
          start_x + finish_x / 2,
          start_y + finish_y / 2
        );
        //context.fill();
        counter += 1;
      });

      canvas.onmousemove = function(e) {
        var counter = 0;
        var rect = this.getBoundingClientRect(),
          x = e.clientX - rect.left,
          y = e.clientY - rect.top;
        var color_map = {
          "#B5FBDD": "#00CF91",
          "#FF756B": "#E20338",
          "#E6E7E8": "#BCBEC0",
        };
        // ctx.clearRect(0, 0, canvas.width, canvas.height); // for demo

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
          context.fillStyle = "black";
          ctx.font = "30px Arial";
          ctx.textAlign = "center";
          ctx.fillText(
            hall_data[counter][1],
            start_x + finish_x / 2,
            start_y + finish_y / 2 - 40
          );
          ctx.fillText(
            hall_data[counter][0],
            start_x + finish_x / 2,
            start_y + finish_y / 2
          );
          counter += 1;
        });
      };
      canvas.addEventListener("click", () =>
        this.som(event, positions, colors)
      );
    },

    get_x_Y(e) {
      var canvas = document.getElementById("myCanvas");
      var rect = canvas.getBoundingClientRect(),
        x = e.clientX - rect.left,
        y = e.clientY - rect.top;
      return [x, y];
    },

    som(e, positions, colors) {
      var choosen = 0;
      var x_y = this.get_x_Y(e);
      var x = x_y[0];
      var y = x_y[1];

      var counter = 0;
      console.log(positions, colors);
      positions.forEach(function(position) {
        var start_x = position[0];
        var start_y = position[1];
        var finish_x = position[2] + start_x;
        var finish_y = position[3] + start_y;
        if (y > start_y && y < finish_y && x > start_x && x < finish_x) {
          if (colors[counter] == "#B5FBDD") {
            choosen = counter;
          } else {
            choosen = -1;
          }
        }
        counter += 1;
      });

      this.choosen = choosen;
    },

    make_reservation() {
      if (this.choosen > 0) {
        alert("Wybrany kort : " + " " + (this.choosen + 1));
        var date = document.getElementById("date-check").value;
        var curentTime = document.getElementById("curent-time").innerText;
        var time = curentTime;
        console.log(date, time);
        this.reservation = {
          id_user: 1,
          id_hall: this.choosen + 1,
          reservation_date: date,
          time_from: time,
          time_to: time,
          full_price: 0,
          is_paid: 1,
          description: "",
        };
        this.add_reservation(this.reservation);
      }
    },

    add_reservation(reservation) {
      instance.post("http://localhost:8080/create/reservation/", reservation);
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
      var curentTime = document.getElementById("curent-time").innerText;
      var time = curentTime + ":00";
      console.log(time);
      var colors = this.get_hole_state(time);
      this.draw_rectangles(colors);
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

    date_listener() {
      var curentTime = document.getElementById("curent-time").innerText;
      var time = curentTime;
      var colors = this.get_hole_state(time);
      this.draw_rectangles(colors);
    },

    get_hole_state(time) {
      var result = [];
      this.hallSource.forEach((element) => {
        if (element.hallType.type == this.curent_type) {
          var hall_busy = false;
          this.reservationSource.forEach((reservation) => {
            if (element.id == reservation.sportHall.id) {
              var date = document.getElementById("date-check");
              if (
                reservation.timeFrom == time + ":00" &&
                reservation.reservationDate == date.value
              ) {
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

    set_min_date() {
      var tomorrow = new Date();
      var dd = tomorrow.getDate() + 1;
      var mm = tomorrow.getMonth() + 1; //January is 0!
      var yyyy = tomorrow.getFullYear();

      var max_date = new Date();
      max_date.setMonth(max_date.getMonth() + 3);
      var max_dd = max_date.getDate() + 1;
      var max_mm = max_date.getMonth() + 1; //January is 0!
      var max_yyyy = max_date.getFullYear();
      if (dd < 10) {
        dd = "0" + dd;
      }
      if (mm < 10) {
        mm = "0" + mm;
      }
      if (max_dd < 10) {
        max_dd = "0" + max_dd;
      }
      if (max_mm < 10) {
        max_mm = "0" + max_mm;
      }

      tomorrow = yyyy + "-" + mm + "-" + dd;
      max_date = max_yyyy + "-" + max_mm + "-" + max_dd;
      document.getElementById("date-check").setAttribute("min", tomorrow);
      document.getElementById("date-check").setAttribute("max", max_date);
      var dateControl = document.querySelector('input[type="date"]');
      dateControl.value = tomorrow;
    },
  },
  mounted() {
    this.getReservations();
    this.getHalls();
    this.$nextTick(this.set_min_date());
    var start_colors = this.get_hole_state("08:00");
    this.$nextTick(this.draw_rectangles(start_colors));
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
.navbar-background {
  height: 113px;
  width: 100%;
  background-color: black;
}

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
  width: 70%;
}

.time-element {
  display: inline;
}

.date-check {
  display: inline;
  margin-left: 3em;
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

.curent-time {
  margin-left: auto;
}

.button {
  display: inline-block;
  margin-left: 3em;
  height: 50px;
  line-height: 42px;
  padding-right: 30px;
  padding-left: 70px;
  position: relative;
  background-color: rgb(41, 127, 184);
  color: rgb(255, 255, 255);
  text-decoration: none;
  text-transform: uppercase;
  letter-spacing: 1px;
  margin-bottom: 15px;

  border-radius: 5px;
  -moz-border-radius: 5px;
  -webkit-border-radius: 5px;
  text-shadow: 0px 1px 0px rgba(0, 0, 0, 0.5);
  -ms-filter: "progid:DXImageTransform.Microsoft.dropshadow(OffX=0,OffY=1,Color=#ff123852,Positive=true)";
  zoom: 1;
  filter: progid:DXImageTransform.Microsoft.dropshadow(OffX=0,OffY=1,Color=#ff123852,Positive=true);

  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.2);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.2);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.2);
  -ms-filter: "progid:DXImageTransform.Microsoft.dropshadow(OffX=0,OffY=2,Color=#33000000,Positive=true)";
  filter: progid:DXImageTransform.Microsoft.dropshadow(OffX=0,OffY=2,Color=#33000000,Positive=true);
}

.button span {
  position: absolute;
  left: 0;
  width: 50px;
  background-color: rgba(0, 0, 0, 0.5);

  -webkit-border-top-left-radius: 5px;
  -webkit-border-bottom-left-radius: 5px;
  -moz-border-radius-topleft: 5px;
  -moz-border-radius-bottomleft: 5px;
  border-top-left-radius: 5px;
  border-bottom-left-radius: 5px;
  border-right: 1px solid rgba(0, 0, 0, 0.15);
}

.button:hover span,
.button.active span {
  background-color: rgb(0, 102, 26);
  border-right: 1px solid rgba(0, 0, 0, 0.3);
}

.button:active {
  margin-top: 2px;
  margin-bottom: 13px;

  -moz-box-shadow: 0px 1px 0px rgba(255, 255, 255, 0.5);
  -webkit-box-shadow: 0px 1px 0px rgba(255, 255, 255, 0.5);
  box-shadow: 0px 1px 0px rgba(255, 255, 255, 0.5);
  -ms-filter: "progid:DXImageTransform.Microsoft.dropshadow(OffX=0,OffY=1,Color=#ccffffff,Positive=true)";
  filter: progid:DXImageTransform.Microsoft.dropshadow(OffX=0,OffY=1,Color=#ccffffff,Positive=true);
}

.button.turquoise {
  background: #1abc9c;
}

.slidecontainer {
  width: 100%;
}

.slider {
  -webkit-appearance: none;
  width: 35%;
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
