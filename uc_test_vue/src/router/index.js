import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/dashboard'
        },
        {
            path: '/',
            component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
            meta: { title: '自述文件' },
            children: [
                {
                    path: '/dashboard',
                    component: () => import(/* webpackChunkName: "dashboard" */ '../components/page/Dashboard.vue'),
                    meta: { title: '系统首页' }
                },
                {
                    path: '/user',
                    component: () => import(/* webpackChunkName: "icon" */ '../components/page/userList.vue'),
                    meta: { title: '员工列表' }
                },
                {
                    path: '/addUser',
                    // hidden:true,
                    component: () => import(/* webpackChunkName: "icon" */ '../components/user/addUser.vue'),
                    meta: { title: '新增员工' }
                },
                {
                    path: '/change',
                    // hidden:true,
                    component: () => import(/* webpackChunkName: "icon" */ '../components/user/changeInfo.vue'),
                    meta: { title: '修改信息' }
                },
                {
                    path: '/other',
                    component: () => import(/* webpackChunkName: "icon" */ '../components/page/other.vue'),
                    meta: { title: '员工列表2' }
                },
            ]
        },
        {
            path: '/login',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
            meta: { title: '登录' }
        },
    ]
});
