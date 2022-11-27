import axios from 'axios'

const NEWS_API_URL = 'http://localhost:8080/api/news'

class NewsService{
    getNewsList(){
        return axios.get(NEWS_API_URL);
    }
}

export default new NewsService()