<template>
  <Header class="header"></Header>
  <h1>Schedule</h1>
  <div v-if="group" class="add"><router-link class="link" :to="{name:'editSchedule', params:{sg_id:group.id}}">
    <font-awesome-icon class="icon" icon="circle-plus" /> Edit group schedule</router-link></div>
  <div class="inputGroup">
  <label >Enter group:</label>
<input type="text" id="group" v-model="groupName">
    <button @click="getSchedules">Submit</button>
  </div>
<div class="main">
  <div class="monday">
    <h2>Monday</h2>
    <div class="block" v-for="s in schedules" v-bind:key="s.id" >
      <div v-show="s.day==='Monday'">
      <h3>{{s.discipline.name}}</h3>
        <h3>{{s.teacher.name}} {{s.teacher.surname}} {{s.teacher.patronymic}}</h3>
        <h3>{{s.time}}</h3>
        <h3>Classroom: {{s.classroom}}</h3>
      </div>
    </div>
  </div>
  <div class="tuesday">
    <h2>Tuesday</h2>
    <div class="block" v-for="s in schedules" v-bind:key="s.id" >
      <div v-show="s.day==='Tuesday'">
        <h3>{{s.discipline.name}}</h3>
        <h3>{{s.teacher.name}} {{s.teacher.surname}} {{s.teacher.patronymic}}</h3>
        <h3>{{s.time}}</h3>
        <h3>Classroom: {{s.classroom}}</h3>
      </div>
    </div>
  </div>
  <div class="wednesday">
    <h2>Wednesday</h2>
    <div class="block" v-for="s in schedules" v-bind:key="s.id" >
      <div v-show="s.day==='Wednesday'">
        <h3>{{s.discipline.name}}</h3>
        <h3>{{s.teacher.name}} {{s.teacher.surname}} {{s.teacher.patronymic}}</h3>
        <h3>{{s.time}}</h3>
        <h3>Classroom: {{s.classroom}}</h3>
      </div>
    </div>
  </div>
  <div class="thursday">
    <h2>Thursday</h2>
    <div class="block" v-for="s in schedules" v-bind:key="s.id" >
      <div v-show="s.day==='Thursday'">
        <h3>{{s.discipline.name}}</h3>
        <h3>{{s.teacher.name}} {{s.teacher.surname}} {{s.teacher.patronymic}}</h3>
        <h3>{{s.time}}</h3>
        <h3>Classroom: {{s.classroom}}</h3>
      </div>
    </div>
  </div>
  <div class="friday">
    <h2>Friday</h2>
    <div class="block" v-for="s in schedules" v-bind:key="s.id" >
      <div v-show="s.day==='Friday'">
        <h3>{{s.discipline.name}}</h3>
        <h3>{{s.teacher.name}} {{s.teacher.surname}} {{s.teacher.patronymic}}</h3>
        <h3>{{s.time}}</h3>
        <h3>Classroom: {{s.classroom}}</h3>
      </div>
    </div>
  </div>
</div>

  <Footer class="footer"></Footer>

</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import ScheduleS from "../../services/ScheduleS.js"


export default {
  name: "Schedule",
  components: {
    Header,
    Footer
  },
  data() {
    return {
      schedules: [],
      groupName:'',
      group:null
    }
  },
  methods: {
    getSchedules() {
      ScheduleS.findDayScheduleByGroup(this.groupName).then((response) => {
        this.schedules = response.data;
        this.group=response.data[0].group
      })
    }
  }
}
</script>

<style scoped>
.add{
  margin-left: 30px;
  width: 250px;
  font-family: sans-serif;
  font-size: 20px;
}
.link{
  text-decoration: none;
  color: cornflowerblue;
}
.block{
  background-color: rgba(115, 196, 239, 0.35);
}
.main{
  display: grid;
  grid-column-gap: 20px;
  grid-template-columns: 280px 280px 280px 280px 280px;
}
.header{
  margin-bottom: 60px;
}

.footer{
  position:static;
  bottom:0;
  margin-top: 180px;
}

label{
  font-size: 25px;
  font-weight: bold;
  font-family: sans-serif;
  text-align: center;
  color: #42424b;
}
input{
  width: 100px;
  height: 25px;
  font-family: sans-serif;
  font-size: 15px;
}
.inputGroup{
  margin-left: 600px;
  margin-bottom: 100px;
}
h2{
  color: #42424b;
  font-family: sans-serif;
  font-size: 25px;
}
h1{
  font-size: 30px;
  color:#42424b ;
  text-align: center;
  margin-bottom: 50px;
}
label{
  font-family: sans-serif;
  font-size: 15px;
}
button{
  margin-left: 10px;
  width: 80px;
  height: 30px;
  font-size: 15px;
  font-family: sans-serif;
  background-color: rgba(115, 196, 239, 0.81);
}
button:hover{
  color:rgba(115, 196, 239, 0.81) ;
  background-color:#42424b ;
}
</style>