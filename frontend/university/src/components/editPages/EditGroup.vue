<template>
  <Header class="header"></Header>
  <h1 class="t_h">Edit Group</h1>
<div v-if="group">
  <h2 >Edit  name:</h2>
  <input type="text" v-model="group.name"><br>
  <h2 >Edit course:</h2>
  <input type="text" v-model="group.course"><br>

  <button @click="updateGroup">Save</button>
  </div>
  <Footer class="footer"></Footer>
</template>

<script>
import Header from "../Header.vue";
import Footer from "../Footer.vue";
import GroupS from "../../services/GroupS.js"

export default {
  name: "AddGroup",
  components: {
    Header,
    Footer
  },
  data(){
    return{
      group:null
    }
  },
  methods: {
    getGroup(id){
      GroupS.getById(id).then((response)=>{
        this.group=response.data;
      });
    },
    updateGroup(){
      GroupS.update(this.group.id, this.group).then(response=>{console.log('Updated successfully')})
      this.$router.go(-1)
    }
  },
  created(){
    this.getGroup(this.$route.params.ge_id)
  }

}
</script>

<style scoped>
.header{
  margin-bottom: 60px;
}

.footer{
  position:static;
  bottom:0;
  margin-top: 100px;
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
input{
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