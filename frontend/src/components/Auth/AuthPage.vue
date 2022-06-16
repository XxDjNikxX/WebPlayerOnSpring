<template>
<section class="text-gray-600 font-body overflow-hidden bg-indigo-200 dark:bg-indigo-400 h-screen dark:text-white">
  <div class="container px-5 py-24 mx-auto rounded-md">
    <div class="mx-auto flex items-center justify-center flex-wrap">
       <div class="border b-2 mr-5 rounded-md items-center shadow-lg">
            <img alt="logo" src="../../assets/IMG_0083.png"/>
       </div>
      <div class="lg:w-1/2 w-full lg:pl-10 lg:py-6 mt-6 lg:mt-0 dark:bg-slate-800 shadow-lg bg-slate-200  rounded-md">
        <h1 class="text-3xl font-medium mb-1 dark:text-white text-">Ruiner Player</h1>
        <p class="text-justify lg:pr-5 justify-center">Привет, это мой дипломный проект :).</p>
        <div class="flex mt-2 items-center border-b-2 dark:border-slate-200 border-black mb-5 mr-5"/>
        <div class="flex items-center lg:w-1/2 lg:pr-10">
          <button class="flex text-black bg-white border-0 py-2 px-8 transition duration-300 hover:bg-indigo-400 rounded">Авторизация</button>
           <button class="flex  ml-10 text-black bg-white border-0 py-2 px-8 lg:place-self-auto transition duration-300 hover:bg-indigo-400 rounded">Регистрация</button>
        </div>
      </div>
    </div>
  </div>
</section>
</template>
<script>
    import {
        defineComponent
    } from "vue";

    export default defineComponent({
        name: 'AuthPage',
    });
</script>