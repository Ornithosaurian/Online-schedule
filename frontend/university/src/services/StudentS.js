import http from "../http-common";

class StudentS{

    get(){
        return http.get('/students')
    }
    getById(id){
        return http.get(`/students/${id}`)
    }
    delete(id){
        return http.delete(`/students/${id}`)
    }
    update(id,data){
        return http.put(`/students/${id}`,data)
    }
    add(data){
        return http.post('/students',data)
    }
}
export default new StudentS();