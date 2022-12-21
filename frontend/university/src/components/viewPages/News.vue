<template>
  <Header class="header"></Header>
  <h1 class="d_h">News</h1>

    <div class="new_block" >

      <div class="main_block" v-for="n in news" v-bind:key="n.id">
        <div class="pic">
          <img class="img" :src="n.imgSrc"/>
        </div>
        <router-link class='title' :to="{name:'new', params:{n_id:n.id}}" >{{n.title}}</router-link>
        <p>{{n.date}}</p>
      </div>
    </div>

  <Footer class="footer"></Footer>
</template>

<script>
import Footer from "../Footer.vue"
import Header from "../Header.vue"
import NewS from "../../services/NewS.js"


export default {
  name: "News",
  components:{
    Header,
    Footer
  },
  data(){
    return{
      news:[]
    }
  },

  methods: {
    getNews(){
      NewS.get().then((response)=>{
        this.news=response.data;
      });
    }
  },
  created(){
    this.getNews()
  }
}
</script>

<style scoped>
.title{
margin-left: 10px;
  font-size: 20px;
  font-weight: bold;
  font-family: sans-serif;
  text-decoration: none;
  color: #42424b;
}
.title:hover{
  color: red;
}
p{
  text-align: right;
  margin-top: -3px;
  font-weight: bold;
  font-size: 15px;
  margin-right: 20px;
  font-family: sans-serif;

}
.main_block{
  width: 300px;
  height: 230px;
  background-color: rgba(126, 192, 227, 0.9);

}
.img{
  width: 270px;
  height: 170px;
}
.pic{
  width: 270px;
  height: 170px;
  background-color: #dadade;
  margin-left: 15px;
  margin-top: 13px;
}
.new_block{
  display: grid;
  grid-template-columns: 300px 300px 300px;
  grid-column-gap: 50px;
  grid-row-gap:50px;
  margin-left: 260px;
}


header{
  margin-bottom: 60px;
}

.footer{
  position:relative;
  bottom:0;
}

.d_h{
  color: #42424b;
  text-align: center;
  font-size: 40px;
  margin-bottom: 50px;
  font-family: sans-serif;
}
table{
  display: grid;
  grid-row-gap: 5px;
  width:500px ;
  margin-left: 300px;
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
  grid-template-columns: 400px 50px 50px;
  /*background-color: rgb(218, 218, 222, 0.2);*/
  background: rgba(126, 192, 227, 0.05);
  border-radius: 5px;
  margin-left: 200px;
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