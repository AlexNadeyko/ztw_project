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
    <li class="nav-item">
      <router-link class="nav-link" to="/reservations">Reservations</router-link>
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

  <ul class="navbar-nav ml-auto">
    <button class="btn btn-primary-outline my-2 my-sm-0" type="submit">Sign In</button>
  </ul>
  <ul class="navbar-nav">
    <button style="margin-right: 50px; margin-left: 20px;" class="btn btn-primary-outline my-2 my-sm-0" type="submit">Sign Up</button>
  </ul>
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

</template>


<script>
export default {
  name: 'app',
  
  data() {
    return {
        isTransparent: true,
        isColored: false,
    }
  },
  methods:{
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
    }
  },
  
  mounted () {
    window.addEventListener('scroll', this.onScroll)
  },
  beforeUnmount () {
    window.removeEventListener('scroll', this.onScroll)
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

.navbar-colored{
  background: rgba(0, 0, 0, 0.3);
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

</style>
