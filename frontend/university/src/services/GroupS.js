import http from "../http-common";

class GroupS{

    get(){
        return http.get('/groups')
    }
    get(id){
        return http.get(`/groups/${id}`)
    }
    delete(id){
        return http.delete(`/groups/${id}`)
    }
}
export default new GroupS();