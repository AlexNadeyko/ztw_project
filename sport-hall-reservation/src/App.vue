<template>
  
  <header>

  <nav class="navbar fixed-top scrolling-navbar navbar-expand-sm" v-bind:class="{ 'navbar-transparent': isTransparent, 'navbar-colored': isColored }">
  
  <!-- Brand -->
  <a class="navbar-brand logo" href="#">Thor</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="my-nav-item">
      <router-link class="nav-link" to="/">Home</router-link>
    </li>
    <li class="my-nav-item">
      <router-link  v-if="isAuthenticated" class="nav-link" to="/reservations">Reservations</router-link>
      <!-- <router-link  v-else class="nav-link" to="/sign_in">Sign In</router-link> -->
      <button  v-else onclick="document.getElementById('sign_in_form').style.display='block'" class="nav-link">Reservations</button>
    </li>
    
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Dropdown link
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Link 1</a>
        <a class="dropdown-item" href="#">Link 2</a>
        <a class="dropdown-item" href="#">Link 3</a>
      </div>
    </li>
  </ul>

  
  <ul class="navbar-nav ml-auto" v-if="!isAuthenticated">
    <button  onclick="document.getElementById('sign_in_form').style.display='block'" class="btn btn-primary-outline my-2 my-sm-0" type="submit">Sign In</button>
  </ul>
  <ul class="navbar-nav"  v-if="!isAuthenticated">
    <button onclick="document.getElementById('sign_up_form').style.display='block'" style="margin-right: 50px; margin-left: 20px;" class="btn btn-primary-outline my-2 my-sm-0" type="submit">Sign Up</button>
    
  </ul>

  <ul class="navbar-nav ml-auto" v-if="isAuthenticated">
    <button  v-on:click="log_out"  class="btn btn-primary-outline my-2 my-sm-0" style="margin-right: 50px; margin-left: 20px;" type="submit">Sign Out</button>
</ul>
  <!-- test -->
<!-- <ul class="navbar-nav" v-if="isAuthenticated">
    <button v-on:click="greet" style="margin-right: 50px; margin-left: 20px;" class="btn btn-primary-outline my-2 my-sm-0" type="submit">Test</button>
  </ul> -->
  <!-- test -->

  </nav> 
  </header>

  <router-view />

  <!-- Footer -->
<footer class="page-footer font-small blue">

  <div class="my_container">

  <!-- Footer Links -->
  <div class="container-fluid text-center text-md-left">

    <!-- Grid row -->
    <div class="row">

      <!-- Grid column -->
      <div class="col-md-5 mt-md-0 mt-3">

        <!-- Content -->
        <h3>Thor</h3>
        <p>Cras fermentum odio eu feugiat lide par naso tierra. Justo eget nada terra videa magna
           derita valies darta donna mare fermentum iaculis eu non diam phasellus. Scelerisque felis
            imperdiet proin fermentum leo. Amet volutpat consequat mauris nunc congue.</p>

      </div>
      <!-- Grid column -->

      <hr class="clearfix w-100 d-md-none pb-3">

      <!-- Grid column -->
      <div class="col-md-3 mb-md-0 mb-3">

        <!-- Links -->
        <h5 class="text-uppercase">Useful Links</h5>

        <ul class="list-unstyled">
          <li>
            <router-link class="nav-link" to="/">Home</router-link>
          </li>
          <li>
            <router-link class="nav-link" to="/reservations">Reservations</router-link>
          </li>
          <li>
            <a href="#!">Dysciplines</a>
          </li>
          <li>
            <a href="#!">Gallery</a>
          </li>
        </ul>

      </div>
      <!-- Grid column -->

      <!-- Grid column -->
      <div class="col-md-4 mb-md-0 mb-3">

        <!-- Links -->
        <h5>Our Newsletter</h5>
        <p>Tamen quem nulla quae legam multos aute sint culpa legam noster magna.</p>

        <form action="" method="post">
          <input type="email" name="email">
          <input type="submit" value="Subscrive">
        </form>

      </div>
      <!-- Grid column -->

    </div>
    <!-- Grid row -->

  </div>
  <!-- Footer Links -->

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2020 Copyright:
    <a href="https://thor.com/"> thor.com</a>
  </div>
  <!-- Copyright -->

  </div>

</footer>
<!-- Footer -->


<!-- Modals -->
<div id="sign_in_form" class="modal">
  
  <form class="modal-content animate" @submit.prevent="sign_in">

    <div class="imgcontainer">
      <h1>Sign In</h1>
      <span onclick="document.getElementById('sign_in_form').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>

    <div class="container">
      <label for="uname"><b>Email</b></label>
      <input id="email_sign_in" type="text" placeholder="Enter Email" v-model="email_sign_in" required/>

      <label for="psw"><b>Password</b></label>
      <input id="password_sign_in" type="password" placeholder="Enter Password" v-model="password_sign_in" required/>
        
      <input type="submit" value="Sign In" id="sign_in_submit">        
      
    </div>
  
    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('sign_in_form').style.display='none'" class="cancelbtn">Cancel</button>
      
      <div class="psw my-container-row">
        <p>Need an account?</p>
          <button v-on:click="change_to_sign_up"  type="submit">Sign Up</button>
      </div>
      
    </div>
  </form>
</div>


<div id="sign_up_form" class="modal">
  
  <form class="modal-content animate" @submit.prevent="sign_up">

    <div class="imgcontainer">
      <h1>Sign Up</h1>
      <span onclick="document.getElementById('sign_up_form').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>

    <div class="container">
      <label for="uname"><b>Email</b></label>
      <input id="email_sign_up" type="text" placeholder="Enter Email" v-model="email_sign_up" required/>

      <label for="psw"><b>Password</b></label>
      <input id="password_sign_up" type="password" placeholder="Enter Password" v-model="password_sign_up" required/>
      
      <input type="submit" value="Sign Up">

    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('sign_up_form').style.display='none'" class="cancelbtn">Cancel</button>
      
      <div class="psw my-container-row">
        <p>Have an account?</p>
          <button  v-on:click="change_to_sign_in"  type="submit">Sign In</button>
      </div>
      
    </div>
  </form>
</div>

</template>


<script>
import {useRouter, useRoute} from 'vue-router';
import {onBeforeMount} from 'vue';
import firebase from 'firebase';
import {ref} from 'vue';


export default {
  name: 'app',

  data() {
    return {
        isTransparent: true,
        isColored: false,
        isAuthenticated: false,
    }
  },

  setup () {
    const router = useRouter();
    const route = useRoute();
    
    onBeforeMount(function() {
      firebase.auth().onAuthStateChanged(function(user){
        if (!user) {
          if(route.path == '/reservations'){
            router.replace('/sign_in');
          }
        } 
      });
    });
    





    const email_sign_in = ref("");
    const password_sign_in = ref("");

    const email_sign_up = ref("");
    const password_sign_up = ref("");

        return {
            email_sign_up,
            password_sign_up,
            password_sign_in,
            email_sign_in
        }
  },
  
  methods:{
    check (user) {
      console.log(user)
      
      if(user){
        this.isAuthenticated = true;
      }
      else{
        this.isAuthenticated = false;
      }
    },

    log_out: function(){
      firebase.auth().signOut();
    },

    greet: function () {
      if (firebase
            .auth().currentUser) {
        alert("exist "  + firebase
            .auth().currentUser + ".sis ?" + this.isAuthenticated)
      }
    },

    sign_up: function(){
      firebase
            .auth()
            .createUserWithEmailAndPassword(document.getElementById('email_sign_up').value, document.getElementById('password_sign_up').value)
            .then(document.getElementById('sign_up_form').style.display='none')
            .catch(err => alert(err.message));
    },

    sign_in: function(){
            firebase
            .auth()
            .signInWithEmailAndPassword(document.getElementById('email_sign_in').value, document.getElementById('password_sign_in').value)
            .then(document.getElementById('sign_in_form').style.display='none')
            .catch(err => alert(err.message));
    },


    onScroll () {
    // Get the current scroll position
    const currentScrollPosition = window.pageYOffset || document.documentElement.scrollTop
    
    if(currentScrollPosition < 100){
              this.isTransparent=true;
              this.isColored = false;
              
          } else{ 
              this.isTransparent=false;
              this.isColored = true;
          }
    },
    change_to_sign_in: function(){
      document.getElementById('sign_up_form').style.display='none';
      document.getElementById('sign_in_form').style.display='block';
    },

    change_to_sign_up: function(){
      document.getElementById('sign_in_form').style.display='none';
      document.getElementById('sign_up_form').style.display='block';
    },
  },
  
  computed: {

  },
  mounted () {
    window.addEventListener('scroll', this.onScroll)

    var modal = document.getElementById('sign_in_form');
    var modal2 = document.getElementById('sign_up_form');

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }  
  }

  window.onclick = function(event) {
    if (event.target == modal) {
        modal2.style.display = "none";
    }
  }
    
  },
  beforeUnmount () {
    window.removeEventListener('scroll', this.onScroll)
  },

  created() {
    firebase.auth().onAuthStateChanged(this.check)
  }
  
}

</script>


<style>

#app {
  /* font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px; */
}

html,
body,
header {
  height: 100%;
}

.my-container-row{
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    float: right;

  }

  .my-container-row p {
      width: 150px;
      margin: auto;
      /* margin: 0px; */
  }

  .my-container-row button {
    border: 0;
  width: 45%;
  padding: 10px 18px;
  text-align: center;
  background-color: #18d26e;
  color: #fff;
  transition: 0.3s;
  cursor: pointer;
  }

.navbar-colored{
  background: rgba(0, 0, 0, 0.6);
  padding: 18px 0;
  color: white;
}

.navbar-transparent{
  background: transparent;
  /* background: rgba(0, 0, 0, 0.7); */
  padding: 26px 0;
  color: white;
}

.logo{
  margin-left: 80px;
  font-size: 34px;
  font-family: "Montserrat", sans-serif;
  font-weight: 700;
  letter-spacing: 3px;
  padding-left: 10px;
    border-left: 4px solid #18d26e;
color:white;
}

.logo:hover{
  color:white;
}

.nav-link{
  color: white;
}

.nav-link:hover{
  color: #18d26e;
}

.my-nav-item button {
  background-color: transparent;
  margin: 0px;
  border: none;
  padding: .5rem 1rem;

  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;

  font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,
  "Noto Sans","Liberation Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol",
  "Noto Color Emoji";
}

.my-nav-item button:focus {
  
  border: none;
  box-shadow: none;
  
}


nav .btn-primary-outline {
  background-color: transparent;
  border-color: white;
  color: white;
  font-size: 15px;
  border-width:medium;
  padding: 5px 15px 5px 15px;
  }

nav .btn-primary-outline:hover{
  border-color: #18d26e;
  color: #18d26e;
}

footer h3 {
  border-left: 4px solid #18d26e;
  font-weight: 700;
  letter-spacing: 3px;
  padding: 2px 0 2px 10px;  
  color: #eee;
}

footer {
  background-color: black;
}

footer h5 {
  color: #eee;
}

.my_container {
    
    /* margin-top: 30px;
    margin-bottom: 30px; */
    max-width: 1140px;
    width: 100%;
    margin-left: auto;
    margin-right: auto;

}

footer .nav-link {
  color: #eee;
  padding: 0px 0px 0px 0px;
}

footer .nav-link:hover {
  color:#18d26e;

}

footer {
  padding-top: 40px;
}

footer a{
 color: #eee;
}

footer a:hover{
 color: #18d26e;
}

footer p {
  color: #eee;
}

.footer-copyright {
  color: #eee;
}

form {
  margin-top: 30px;
  background: black;
  /* padding: 6px 10px; */
  position: relative;
}

input[type="email"] {
  border: 0;
  padding: 6px 8px;
  width: 65%;
}

input[type="email"] {
  border: 0;
    padding: 6px 8px;
width: 65%;
}

input[type="submit"] {
  border: 0;
  width: 35%;
  padding: 6px 0;
  text-align: center;
  background-color: #18d26e;
  color: #fff;
  transition: 0.3s;
  cursor: pointer;
}



#sign_in_form .container {
  padding: 16px;
  max-width: 1200px;
}

#sign_up_form .container {
  padding: 16px;
  max-width: 1200px;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 6px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

input:focus[type=text], input:focus[type=password] {
  border: 2px solid #18d26e;
}

input:focus-visible[type=text], input:focus-visible[type=password] {
  outline: none;
}

/* Set a style for all buttons */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}

#sign_in_form input[type="submit"] {
  background-color: #18d26e;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

#sign_in_form input:hover[type="submit"] {
  opacity: 0.8;
}

#sign_up_form input[type="submit"] {
  background-color: #18d26e;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

#sign_up_form input:hover[type="submit"]  {
  opacity: 0.8;
}


</style>
