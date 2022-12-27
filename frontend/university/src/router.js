import {createRouter, createWebHashHistory} from "vue-router";
import EditFaculty from "@/components/editPages/EditFaculty.vue";
import EditDepartment from "@/components/editPages/EditDepartment.vue"
import EditDiscipline from "@/components/editPages/EditDiscipline.vue"
import EditGroup from "@/components/editPages/EditGroup.vue"
import EditStudent from "@/components/editPages/EditStudent.vue"
import EditNew from "@/components/editPages/EditNew.vue"
import EditTeacher from "@/components/editPages/EditTeacher.vue"
import Departments from "@/components/viewPages/Departments.vue"
import Disciplines from "@/components/viewPages/Disciplines.vue"
import Faculties from "@/components/viewPages/Faculties.vue"
import Groups from "@/components/viewPages/Groups.vue"
import Teachers from "@/components/viewPages/Teachers.vue"
import Student from "@/components/viewById/Student.vue"
import News from "@/components/viewPages/News.vue"
import Faculty from "@/components/viewById/Faculty.vue"
import Department from "@/components/viewById/Department.vue"
import Group from "@/components/viewById/Group.vue"
import Teacher from "@/components/viewById/Teacher.vue"
import New from "@/components/viewById/New.vue"
import AddDiscipline from "@/components/addPages/AddDiscipline.vue"
import AddTeacher from "@/components/addPages/AddTeacher.vue"
import AddNew from "@/components/addPages/AddNew.vue"
import AddStudent from "@/components/addPages/AddStudent.vue"
import AddGroup from "@/components/addPages/AddGroup.vue"
import AddFaculty from "@/components/addPages/AddFaculty.vue"
import AddDepartment from "@/components/addPages/AddDepartment.vue"

export default createRouter({
        history: createWebHashHistory(),
        routes: [
            {path: '/', redirect: '/news'},
            {path: '/editFaculty', component: EditFaculty},
            {path: '/disciplines/editDiscipline/:ds_id', name: 'discipline_edit', component: EditDiscipline},
            {path: '/editDepartment', component: EditDepartment},
            {path: '/faculties', name: 'faculties', component: Faculties},
            {path: '/faculties/:f_id', component: Faculty},
            {path: '/faculties/:f_id/departments', name: 'faculty_departments', component: Departments},
            {path: '/faculties/:f_id/departments/:d_id', name: 'department', component: Department},
            {path: '/faculties/:f_id/departments/:d_id/groups', name: 'groups', component: Groups},
            {path: '/faculties/:f_id/departments/:d_id/groups/:g_id', name: 'group', component: Group},
            {path: '/faculties/:f_id/departments/:d_id/groups/:g_id/student/:s_id', name: 'student', component: Student},
            {path: '/teachers', name: 'teachers', component: Teachers},
            {path: '/teachers/:t_id', name: 'teacher', component: Teacher},
            {path: '/news', component: News},
            {path: '/news/:n_id', name: 'new', component: New},
            {path: '/disciplines', component: Disciplines},
            {path: '/disciplines/addDiscipline',name: 'addDiscipline', component: AddDiscipline},
            {path: '/teachers/addTeacher', name:'addTeacher', component: AddTeacher},
            {path: '/teachers/editTeacher/:te_id', name:'editTeacher', component: EditTeacher},
            {path: '/news/addNew',name: 'addNew', component: AddNew},
            {path: '/news/editNew/:ne_id', name: 'editNew', component: EditNew},
            {path: '/faculties/:f_id/departments/:d_id/groups/:g_id/student/editStudent/:se_id', name:'editStudent', component: EditStudent},
            {path: '/faculties/:f_id/departments/:d_id/groups/:g_id/students/addStudent', name: 'addStudent', component: AddStudent},
            {path: '/faculties/:f_id/departments/:d_id/groups/addGroup', name: 'addGroup', component: AddGroup},
            {path: '/faculties/:f_id/departments/:d_id/groups/editGroup/:ge_id', name: 'editGroup', component: EditGroup},
            {path: '/faculties/addFaculty', name:'addFaculty', component: AddFaculty},
            {path: '/faculties/editFaculty/:fe_id', name: 'editFaculty', component: EditFaculty},
            {path: '/faculties/:f_id/departments/addDepartment', name: 'addDepartment', component: AddDepartment},
            {path: '/faculties/:f_id/departments/editDepartment/:de_id', name: 'editDepartment', component: EditDepartment}
        ]
    }
)