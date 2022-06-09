import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'
import Main from '../components/MainPage.vue'
import About from '../components/AboutPage.vue'
import Contact from '../components/ContactPage.vue'


const routes: Array<RouteRecordRaw> = [
    {
      path: "/",
      component: Main
    },
    {
      path: "/about",
      component: About
    },
    {
        path: "/contacts",
        component: Contact
      },
    { path: '/:pathMatch(.*)*', redirect: '/' }
  ];

  const router = createRouter({
      history: createWebHistory(),
      routes
  });

  export default router;