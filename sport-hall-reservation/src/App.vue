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

  <div class="alert alert-success alert-dismissible fade show" role="alert">
  With Bootstrap!
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>

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


</style>
