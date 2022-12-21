import http from "../http-common.js";

class DepartmentS{

    get(){
        return http.get('/departments')
    }
    get(id){
        return http.get(`/departmens/${id}`)
    }
    delete(id){
        return http.delete(`/departmens/${id}`)
    }
}
export default new DepartmentS();