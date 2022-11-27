<template>
  <div>
    <h1>news list</h1>
    <thead>
      <td>Title</td>
      <td>Description</td>
      <td>ImgSrc</td>
      <td>Date</td>
    </thead>
    <tbody>
      <tr v-for="news in newsList" :key="news.id">
        <td>{{news.title}}</td>
        <td>{{news.description}}</td>
        <td>{{news.imgSrc}}</td>
        <td>{{news.date}}</td>
      </tr>
    </tbody>
  </div>
</template>

<script>
import NewsService from '../services/NewsService'

    export default{
        name: 'News',
        data(){
            return{
                newsList : []
            }
        },
        methods:{
            getNewsList(){
                NewsService.getNewsList().then((response) => {
                    this.newsList = response.data;
                })
            }
        },
        created(){
                this.getNewsList()
            }
    }
</script>
