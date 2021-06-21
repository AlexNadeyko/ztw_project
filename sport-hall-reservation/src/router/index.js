import { createWebHistory, createRouter } from "vue-router";
import Home from "@/components/Home.vue";
import Reservation from "@/components/Reservation.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/reservations",
    name: "Reservation",
    component: Reservation,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
