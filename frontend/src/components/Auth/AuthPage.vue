<template>
  <section class="text-gray-600 font-body bg-indigo-200 dark:bg-indigo-400 h-screen dark:text-white lg:h-screen lg:overflow-y-auto">
    <div class="container px-10 py-24 mx-auto rounded-md">
      <div class="mx-auto flex items-center justify-center flex-wrap">
        <div class="border b-2 mr-5 rounded-md items-center shadow-lg">
          <img alt="logo" src="../../assets/IMG_0083.png" />
        </div>
        <div class="lg:w-1/2 w-full lg:pl-10 lg:py-6 mt-6 lg:mt-0 dark:bg-slate-800 shadow-lg bg-slate-200  rounded-md">
          <h1 class="text-3xl font-medium mb-1 dark:text-white text-">Ruiner Player</h1>
          <p class="text-justify lg:pr-5 justify-center">Привет, это мой дипломный проект :).</p>
          <div class="flex mt-2 items-center border-b-2 dark:border-slate-200 border-black mb-5 mr-5" />
          <div class="flex items-center lg:w-2/3">
        <div class="flex flex-wrap px-2">
              <div
                class="dark:bg-slate-800 shadow-lg bg-slate-200  rounded-md">
                <div>
                  <input type="text"
                    class="form-control block w-full px-4 py-2 text-md font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-slate-700 focus:bg-white focus:border-indigo-600 focus:outline-none"
                    id="exampleFormControlInput2" placeholder="Эл. почта" />
                </div>
                <div>
                  <input type="password"
                    class="form-control block w-full px-4 py-2 mt-5 text-md font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-slate-700 focus:bg-white focus:border-indigo-600 focus:outline-none"
                    id="exampleFormControlInput2" placeholder="Пароль" />
                </div>
              </div>
            </div>
          </div>
           <div class="flex mt-5 items-center border-b-2 dark:border-slate-200 border-black mb-5 mr-5" />
            <button
              class="flex ml-8 text-black bg-white border-0 py-2 px-8 lg:place-self-auto transition duration-300 hover:bg-indigo-400 rounded">Регистрация</button>

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