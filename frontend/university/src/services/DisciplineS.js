import http from "../http-common";

class DisciplineS{

    get(){
        return http.get('/disciplines')
    }
    getById(id){
        return http.get(`/disciplines/${id}`)
    }
    delete(id){
        return http.delete(`/disciplines/${id}`)
    }
}
export default new DisciplineS();