<template>
  <Header class="header"></Header>
  <div v-if="department">
    <h1 class="t_h">{{department.shortName}}</h1>

    <img class="img" :src="department.imgSrc"/>
    <p>{{department.description}}</p>
    <router-link class="ref" :to="{name:'department', params:{d_id:department.id}}">See groups of department</router-link>
  </div>
  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import DepartmentS from "../../services/DepartmentS.js"

export default {
  name: "Department",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      department:null
    }
  },
  methods:{
    getDepartment(id){
      DepartmentS.getById(id).then((response)=>{
        this.department=response.data;
      });
    }
  },
  created(){
    this.getDepartment(this.$route.params.d_id)
  }
}
</script>

<style scoped>
.ref{
  font-size: 19px;
  font-weight: bold;
  font-family: sans-serif;
  text-decoration: none;
  margin-left: 630px;
  color: #7ec0e3;
}
.ref:hover{
  color: #42424b;
}
.img{
  margin-left: 625px;
}
p{
  width: 800px;
  font-family: sans-serif;
  font-weight: bold;
  font-size: 16px;
  text-align: center;
  margin-left: 350px;
}

.header{
  margin-bottom: 60px;
}

.footer{
  position:relative;
  bottom:0;
}

.t_h{
  color: #42424b;
  text-align: center;
  font-size: 40px;
  margin-bottom: 50px;
  font-family: sans-serif;
}
table{
  display: grid;
  grid-row-gap: 5px;
  width:300px ;

}
td{
  font-family: sans-serif;
  font-size: 20px;
  font-weight: bold;
}
td a{
  text-decoration: none;
  color: #42424b;
}
td a:hover{
  color: cornflowerblue;
}
tr{
  display: grid;
  grid-template-columns: 200px 250px ;
  background: rgba(126, 192, 227, 0.05);
  border-radius: 5px;
  margin-left: 550px;
}
.icon {
  font-size: 2rem;
}
.edit{
  color: mediumseagreen;
  text-align: center;
}
.delete{
  color: red;
  text-align: center;}
</style>