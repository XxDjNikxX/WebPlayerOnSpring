import { createApp } from 'vue'
import App from './App.vue'
import '../public/main.css'
import './assets/logo_transparent.png'
import './assets/logo.png'
import './assets/IMG_0083.png'
import './assets/favicon.png'
import router from './router/'

createApp(App).use(router).mount('#app')

