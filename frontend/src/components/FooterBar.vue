<template>
    <footer class="shadow-lg bg-slate-800 font-body">
        <div class="w-2/3 mx-auto px-4 text-white">
            <div class="flex justify-between">
                <div class="flex space-x-7 divide-x">
                    <div>
                        <router-link to="/">
                            <a class="flex items-center py-4 ">
                                <img src="../assets/logo_transparent.png" alt="Logo" class="box-border w-20 h-20" />
                                <span
                                    class="font-body hover:text-indigo-500 transition duration-300 text-lg">Runier
                                    Soft</span>
                            </a>
                        </router-link>
                    </div>
                    <div class="flex justify-center">
                        <div
                            class="w-auto h-auto p-8 items-center text-center text-black dark:text-white">
                            Автор проекта:
                            <a href="https://t.me/xxxDjNikxxx">DjNik</a>
                            <div>Рисунок котика: <a href="https://vk.com/littlesadcat">Александра Затонская</a></div>
                        </div>
                          <div class=" p-8  text-center text-black dark:text-white">Cделано с любовью и душой :3</div>
                    </div>

                </div>
            </div>
        </div>
    </footer>
</template>
<script lang="ts">
    import {
        defineComponent
    } from "vue";
    export default defineComponent({
        name: "FooterBar",
    });
</script>