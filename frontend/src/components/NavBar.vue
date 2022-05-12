<template>
    <nav class="bg-white shadow-lg  dark:bg-slate-800">
        <div class="max-w-6xl mx-auto px-4">
            <div class="flex justify-between">
                <div class="flex space-x-7">
                    <div>
                        <router-link to="/">
                            <a class="flex items-center py-4  ">
                                <img src="../assets/logo_transparent.png" alt="Logo" class="box-border w-20 h-20" />
                                <span
                                    class="font-body text-white hover:text-indigo-500  border-indigo-500 border-b-4 transition duration-300 text-lg">Runier
                                    Player</span>
                            </a>
                        </router-link>
                    </div>
                    <div class="hidden md:flex items-center space-x-2">
                        <router-link to="/">
                            <a class="py-4 px-4 text-white   hover:text-indigo-500 font-body transition duration-300 ">Домой</a>
                        </router-link>
                        <router-link to="/about">
                            <a class="py-4 px-4 text-white font-body  hover:text-indigo-500 transition duration-300">О
                                плерее</a>
                        </router-link>
                        <router-link to="/contacts">
                            <a class="py-4 px-4 text-white font-body  hover:text-indigo-500 transition duration-300">Обратная
                                связь</a>
                        </router-link>
                    </div>
                </div>
                <div class="hidden md:flex items-center space-x-3 ">
                    <a href=""
                        class="py-2 px-2 pr-5 pl-5 font-medium text-white rounded bg-indigo-500 hover:bg-indigo-400 hover:text-white transition duration-300">Войти</a>
                    <a href=""
                        class="py-2 px-2 pr-5 pl-5 font-medium text-white bg-indigo-500 rounded hover:bg-indigo-400 transition duration-300">Регистрация</a>
                </div>
            </div>
        </div>
    </nav>
</template>
<script>
    import {defineComponent} from "vue";
    export default defineComponent({
        name: "NavBar",
    });
</script>