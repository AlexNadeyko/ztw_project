
import { createWebHistory, createRouter } from "vue-router";
import Home from "@/components/Home.vue";
import Reservation from "@/components/Reservation.vue";
import About from "@/components/About.vue"
import Sign_In from "@/components/Sign_In.vue"
import Sign_Up from "@/components/Sign_Up.vue"

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
  {
    path: "/about",
    name: "About",
    component: About,
  },
  {
    path: "/sign_in",
    name: "Sign_In",
    component: Sign_In,
  },
  {
    path: "/sign_up",
    name: "Sign_Up",
    component: Sign_Up,
  },
  
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;