import { createApp } from 'vue'
import App from './App.vue'
import '../public/assets/main.css'
import './assets/logo_transparent.png'
import router from './router/'

createApp(App).use(router).mount('#app')

