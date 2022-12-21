import http from "../http-common.js";

class DepartmentS{

    get(){
        return http.get('/departments')
    }
    getById(id){
        return http.get(`/departments/${id}`)
    }
    delete(id){
        return http.delete(`/departments/${id}`)
    }
}
export default new DepartmentS();