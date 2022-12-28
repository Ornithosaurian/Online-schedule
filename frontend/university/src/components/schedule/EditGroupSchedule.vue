<template>
  <Header class="header"></Header>
  <div  class="add"><router-link class="link" :to="{name:'addSchedule', params:{sg_id:group.id}}">
    <font-awesome-icon class="icon" icon="circle-plus" /> Add schedule</router-link></div>

  <h1>Schedule</h1>


  <div class="main">
    <div class="monday">
      <h2>Monday</h2>
      <div class="block" v-for="s in schedules" v-bind:key="s.id" >
        <div v-show="s.day==='Monday'">
          <h3>{{s.discipline.name}}</h3>
          <h3>{{s.teacher.name}} {{s.teacher.surname}} {{s.teacher.patronymic}}</h3>
          <h3>{{s.time}}</h3>
          <h3>Classroom: {{s.classroom}}</h3>
          <div class="icons">
            <div><router-link class="edit" :to="{name:'editOneSchedule', params:{sche_id:s.id}}">
              <font-awesome-icon class="icon" icon="pen-to-square" />
            </router-link></div>
            <div class="delete" @click="deleteSchedule(s.id)">
              <font-awesome-icon class="icon" icon="trash-can"/>
            </div>
        </div>
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
          <div class="icons">
            <div><router-link class="edit" :to="{name:'editOneSchedule', params:{sche_id:s.id}}">
              <font-awesome-icon class="icon" icon="pen-to-square" />
            </router-link></div>
            <div class="delete" @click="deleteSchedule(s.id)">
              <font-awesome-icon class="icon" icon="trash-can"/>
            </div>
        </div>
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
          <div class="icons">
            <div><router-link class="edit" :to="{name:'editOneSchedule', params:{sche_id:s.id}}">
              <font-awesome-icon class="icon" icon="pen-to-square" />
            </router-link></div>
            <div class="delete" @click="deleteSchedule(s.id)">
              <font-awesome-icon class="icon" icon="trash-can"/>
            </div>
        </div>
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
          <div class="icons">
            <div><router-link class="edit" :to="{name:'editOneSchedule', params:{sche_id:s.id}}">
              <font-awesome-icon class="icon" icon="pen-to-square" />
            </router-link></div>
            <div class="delete" @click="deleteSchedule(s.id)">
              <font-awesome-icon class="icon" icon="trash-can"/>
            </div>
        </div>
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
          <div class="icons">
            <div><router-link class="edit" :to="{name:'editOneSchedule', params:{sche_id:s.id}}">
              <font-awesome-icon class="icon" icon="pen-to-square" />
            </router-link></div>
            <div class="delete" @click="deleteSchedule(s.id)">
              <font-awesome-icon class="icon" icon="trash-can"/>
            </div>
        </div>
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
import GroupS from "../../services/GroupS.js"

export default {
  name: "EditGroupSchedule",
  components: {
    Header,
    Footer
  },
  data() {
    return {
      schedules: [],
      group:null
    }
  },
  methods: {
    getSchedules(group) {
      ScheduleS.findScheduleByGroupId(group).then((response) => {
        this.schedules = response.data;

      });
    },
    deleteSchedule(id){
      ScheduleS.delete(id).then(response=>{console.log('Deleted successfully')})
      window.location.reload()
    },
    getGroup(id){
      GroupS.getById(id).then((response)=>{
        this.group=response.data;
      });
    }
  },
  created(){
    this.getSchedules(this.$route.params.sg_id)
    this.getGroup(this.$route.params.sg_id)
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
.icons{
  display: grid;
  grid-template-columns: 50px 50px;
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
  position:relative;
  bottom:0;
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
.icon {
  font-size: 2rem;
}
.edit{
  color: mediumseagreen;
  text-align: center;
}
.edit:hover{
  color: black;
}
.delete{
  color: red;
  text-align: center;}
.delete:hover{
  color: black;
}
</style>