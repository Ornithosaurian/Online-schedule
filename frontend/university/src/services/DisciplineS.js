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
    update(id,data){
        return http.put(`/disciplines/${id}`,data)
    }
    add(data){
        return http.post('/disciplines',data)
    }
}
export default new DisciplineS();