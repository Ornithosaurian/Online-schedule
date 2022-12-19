<template xmlns="http://www.w3.org/1999/html">
   <nav>
     <img src="https://kpi.ua/files/images-page/kpi-big-logo.png" alt="logo">
    <h1 class="header_h">KPI</h1>
    <div class="menu">
      <div class="routes">
        <div>
          <font-awesome-icon class="icon" icon="person-chalkboard" />
          <a href="#/disciplines">Disciplines</a>
        </div>
      </div>
      <div class="routes">
        <div>
        <font-awesome-icon class="icon" icon="building-user" />
          <a href="#/faculties">Faculties</a>
      </div>
      </div>
      <div>
      <div class="routes">
        <div>
        <font-awesome-icon class="icon" icon="user-tie" />
        <a href="#/teachers">Teachers</a>
      </div>
      </div>
      </div>
      <div class="routes">
        <div>
        <font-awesome-icon class="icon" icon="bullhorn" />
        <a href="#/news">News</a>
      </div>
      </div>
      <div class="routes">
        <div>
          <font-awesome-icon class="icon" icon="calendar-days" />
          <a href="#/schedule">Schedule</a>
        </div>
      </div>

    </div>
<!--  <button class="h_btn">-->
<!--    <font-awesome-icon class="icon" icon="bars" />-->
<!--  </button>-->
  </nav>
</template>

<script>

export default {
  name:'Header',
}
</script>

<style scoped>

*{
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
nav{
  position: relative;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: white;
  padding: 1rem 1rem;
}
nav h1{
  letter-spacing: 5px;
  padding: 0.5rem 1rem;
  transition:0.3s;
}
.menu{
  align-items: center;
  display: grid;
  grid-template-columns: 190px 190px 180px 150px 150px;
  margin: 0 3rem;
}

.routes a{
  margin: 0 1rem;
  color: #7f7f87;
  text-decoration: none;
  transition: 0.3s;
  font-family:sans-serif ;
  font-size: 20px;
  font-weight: bold;
}
.menu .routes a:hover{
  color: black;
}

/*.h_btn{*/
/*  appearance: none;*/
/*  outline: none;*/
/*  border: none;*/
/*  background: none;*/
/*  cursor: none;*/

/*  display:block;*/
/*  width: 7rem;*/
/*  height: 4rem;*/
/*}*/
.icon{
  color: #70c3ef;
  font-size: 2rem;
}

.header_h{
  color: #414144;
  margin: 0;
  font-size: 60px;
  padding-top: 30px;
  font-family: sans-serif;
  text-align: center;
}
img{
  width: 130px;
margin-right: -200px;
}
</style>