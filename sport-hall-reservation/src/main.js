import '@babel/polyfill'
import 'mutationobserver-shim'

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'


import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import firebase from 'firebase'

const firebaseConfig = {
    apiKey: "AIzaSyAKymWGtZa0Fc72sh8Z1i2V-kVzIHmMv4c",
    authDomain: "sport-complex-auth.firebaseapp.com",
    projectId: "sport-complex-auth",
    storageBucket: "sport-complex-auth.appspot.com",
    messagingSenderId: "1007771722843",
    appId: "1:1007771722843:web:2c0bb193fecc2eb5328b7e"
  };

  firebase.initializeApp(firebaseConfig);

createApp(App).use(router).mount('#app')