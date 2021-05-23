<template>
  <div id="app" class="small-container">
    <Reservation reservations-table :reservationSource="reservations"  :hallSource="halls" />
  </div>
</template>

<script>
import Reservation from "@/components/Reservation.vue";
// import axios from "axios";

// const SERVER_URL = "http://localhost:8080";
// const instance = axios.create({
//   baseURL: SERVER_URL,
//   timeout: 1000,
// });

export default {
  name: "App",
  components: {
    Reservation,
  },
  data() {
    return {
      reservations: [],
      halls: [],
    };
  },
  methods: {
    async getReservations() {
      try {
        const response = await fetch("http://localhost:8080/get/reservations");
        const data = await response.json();
        this.reservations = data;
      } catch (error) {
        console.error(error);
      }
    },

    async getHalls() {
      try {
        const response = await fetch("http://localhost:8080/get/halls");
        const data = await response.json();
        this.halls = data;
      } catch (error) {
        console.error(error);
      }
    },
  },
  mounted() {
    this.getReservations();
    this.getHalls();
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
