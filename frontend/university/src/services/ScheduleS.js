import http from "../http-common.js";

class ScheduleS{

    get(){
        return http.get('/timetables')
    }
    getById(id){
        return http.get(`/timetables/${id}`)
    }
    delete(id){
        return http.delete(`/timetables/${id}`)
    }
    update(id,data){
        return http.put(`/timetables/${id}`,data)
    }
    add(data){
        return http.post('/timetables',data)
    }
    findDayScheduleByGroup(group){
        return http.get(`/timetables/sort?group=${group}`)
    }
    findScheduleByGroupId(group){
        return http.get(`/timetables/sortByGroupName?group=${group}`)
    }
}
export default new ScheduleS();