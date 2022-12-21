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
}
export default new StudentS();