import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'
import Main from '../components/MainPage.vue'
import About from '../components/AboutPage.vue'
import Contact from '../components/ContactPage.vue'
import Auth from '../components/Auth/AuthPage.vue'

const routes: Array<RouteRecordRaw> = [
    {
      path:"/auth",
      component: Auth,
    },
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
      history: createWebHistory(process.env.BASE_URL),
      routes
  });

  export default router;