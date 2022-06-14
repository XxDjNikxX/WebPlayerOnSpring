import { createApp } from 'vue'
import App from './App.vue'
import '../public/main.css'
import './assets/logo_transparent.png'
import './assets/logo.png'
import '../public/favicon.png'
import router from './router/'

createApp(App).use(router).mount('#app')

