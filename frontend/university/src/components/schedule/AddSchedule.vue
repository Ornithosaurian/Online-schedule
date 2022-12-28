<template>
  <Header class="header"></Header>
  <h1 class="t_h">Add schedule</h1>
<div class="block">
  <h2 >Select discipline:</h2>
  <select  v-model="schedule.discipline">
    <option v-for="(discipline,index) in disciplines"
            :value="discipline.value"
            :key="index">
      {{ discipline.name }}
    </option>
  </select>
  <h2 >Select teacher:</h2>
  <select   v-model="schedule.teacher">
    <option v-for="(teacher,index) in teachers"
            :value="teacher.value"
            :key="index">
      {{ teacher.name }}
    </option>
  </select>
  <h2 >Enter schedule name:</h2>
  <input type="text" v-model="schedule.name"><br>
  <h2 >Enter time:</h2>
  <input type="text" placeholder="12:20" v-model="schedule.time"><br>
  <h2 >Enter classroom:</h2>
  <input type="text" placeholder="59" v-model="schedule.classroom"><br>
  <h2 >Enter day:</h2>
  <input type="text" placeholder="Monday" v-model="schedule.day"><br>
  <button @click="addSchedule">Add</button>
  </div>
  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import TeacherS from "../../services/TeacherS.js"
import DisciplineS from "../../services/DisciplineS.js"
import GroupS from "../../services/GroupS.js"
import ScheduleS from "../../services/ScheduleS.js"


export default {
  name: "AddSchedule",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      schedule:{
        name:'',
        teacher:null,
        discipline:null,
        group:null,
        time:'',
        classroom:'',
        day:''
      },
      disciplines:[],
      teachers:[]
    }

  },
  methods: {
    getGroup(id){
      GroupS.getById(id).then((response)=>{
        this.group=response.data;
      });
    },
    getDisciplines(){
      DisciplineS.get().then((response)=>{
        this.disciplines=response.data;
      })
    },
    getTeacher() {
      TeacherS.get().then((response) => {
        this.teachers = response.data;
      });
    },
    addSchedule(){
      ScheduleS.add(this.schedule).then(response=>{console.log('Added successfully')})
      this.$router.go(-1)
    }
  },
  created(){
    this.getGroup(this.$route.params.sg_id)
    this.getDisciplines()
    this.getTeacher()
  }
}
</script>

<style scoped>
.header{
  margin-bottom: 60px;
}

.footer{
  position:relative;
  bottom:0;
}
button{
  margin-left: 720px;
  margin-top: 20px;
  width: 80px;
  height: 50px;
  font-size: 20px;
  font-family: sans-serif;
  background-color: rgba(115, 196, 239, 0.81);

}
h2{
  font-size: 25px;
  font-weight: bold;
  font-family: sans-serif;
  text-align: center;
  color: #42424b;
}
input,select{
  width: 600px;
  height: 25px;
  margin-left: 450px;
  font-family: sans-serif;
  font-size: 15px;
}
.t_h{
  color: #42424b;
  text-align: center;
  font-size: 40px;
  margin-bottom: 50px;
  font-family: sans-serif;
}

</style>