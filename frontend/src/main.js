import { createApp } from 'vue'
import App from './App.vue'
import '../public/assets/main.css'
import './assets/logo_transparent.png'
import router from './router/'
import VueAxios from 'vue-axios' 
import axios from 'axios';

createApp(App).use(VueAxios,axios).use(router).mount('#app')

