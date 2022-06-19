<template class="overflow-y-hidden lg:h-1/4 h-2/3">
  <NavBar/>
  <router-view></router-view>
  <FooterBar></FooterBar>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import NavBar from './components/NavBar.vue';
import FooterBar from './components/FooterBar.vue';

export default defineComponent({
  name: 'App',
  components: {
    NavBar,
    FooterBar
  }
});
</script>


