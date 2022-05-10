<template>
  <section class="player">
    <div class="w-full font-body">
      <div class="flex items-center justify-center h-screen bg-whie dark:bg-indigo-400">
        <div class="bg-slate-200 shadow-lg rounded-md w-3/5 dark:bg-slate-800 dark:text-white">
          <div class="flex ">
            <div class="w-full p-8">
              <div class="flex justify-between">
                <div>
                  <h3 class="text-2xl text-grey-darkest font-body">{{current.title}}</h3>
                  <p class="text-sm text-grey mt-1">{{current.artist}}</p>
                </div>
                <div class="">
                  <svg class="w-6 h-6 hover:fill-indigo-400 dark:fill-white transition duration-300"
                    xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path
                      d="M10 3.22l-.61-.6a5.5 5.5 0 0 0-7.78 7.77L10 18.78l8.39-8.4a5.5 5.5 0 0 0-7.78-7.77l-.61.61z"
                      c />
                  </svg>
                </div>
              </div>
              <div class="flex justify-between items-center mt-8">
                <div class="text-gray-600 dark:text-white">
                  <svg class="w-8 h-8 hover:fill-indigo-400 transition duration-300" fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path
                      d="M6.59 12.83L4.4 15c-.58.58-1.59 1-2.4 1H0v-2h2c.29 0 .8-.2 1-.41l2.17-2.18 1.42 1.42zM16 4V1l4 4-4 4V6h-2c-.29 0-.8.2-1 .41l-2.17 2.18L9.4 7.17 11.6 5c.58-.58 1.59-1 2.41-1h2zm0 10v-3l4 4-4 4v-3h-2c-.82 0-1.83-.42-2.41-1l-8.6-8.59C2.8 6.21 2.3 6 2 6H0V4h2c.82 0 1.83.42 2.41 1l8.6 8.59c.2.2.7.41.99.41h2z" />
                  </svg>
                </div>
                <div class="text-gray-600 dark:text-white" @click="prev">
                  <svg class="w-8 h-8 hover:fill-indigo-400 transition duration-300" fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path d="M4 5h3v10H4V5zm12 0v10l-9-5 9-5z" /></svg>
                </div>
                <div @click="pause"
                  class="p-8 rounded-full dark:bg-white shadow-lg dark:text-black hover:fill-indigo-400 transition duration-300"
                  v-if="isPlaying">
                  <svg class="w-8 h-8" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path d="M5 4h3v12H5V4zm7 0h3v12h-3V4z"></path>
                  </svg>
                </div>
                <div @click="play"
                  class="p-8 rounded-full dark:bg-white shadow-lg dark:text-black hover:fill-indigo-400 transition duration-300"
                  v-else>
                </div>
                <div class="text-gray-700" @click="next">
                  <svg class="w-8 h-8 hover:fill-indigo-400 dark:text-white transition duration-300" fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path d="M13 5h3v10h-3V5zM4 5l9 5-9 5V5z" /></svg>
                </div>
                <div class="text-gray-700 dark:text-white ">
                  <svg class="w-8 h-8 hover:fill-indigo-400 transition duration-300" fill="currentColor"
                    xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path
                      d="M5 4a2 2 0 0 0-2 2v6H0l4 4 4-4H5V6h7l2-2H5zm10 4h-3l4-4 4 4h-3v6a2 2 0 0 1-2 2H6l2-2h7V8z" />
                  </svg>
                </div>
              </div>
            </div>
          </div>
          <div class="mx-8 py-4">
            <div class="flex justify-between text-sm">
              <p>0:00</p>
              <p>4:20</p>
            </div>
            <div class="mt-1">
              <div class="h-1  rounded-full  bg-gradient-to-r from-slate-500 bg-indigo-600">
                <div class="w-1/5 h-1 bg-red-light rounded-full relative">
                  <span
                    class="w-4 h-4 bg-indigo-900 absolute pin-r pin-b -mt-1 rounded-full shadow dark:bg-white hover:bg-indigo-400 transition duration-300"></span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

</template>
<script>
import axios from 'axios';
  export default {
    name: 'App',
    data() {
      return {
        current: {},
        index: 0,
        isPlaying: false,
        songs: [
          {
            title: '',
            artist: '',
            src: '',
          }
        ],
        player: new Audio()
      }
    },
    methods: {
  
      play(song) {
        if (typeof song.src != "undefined") {
          this.current = song;
          this.player.src = this.current.src;
        }
        this.player.play();
        this.player.addEventListener('ended', function () {
          this.index++;
          if (this.index > this.songs.length - 1) {
            this.index = 0;
          }
          this.current = this.songs[this.index];
          this.play(this.current);
        }.bind(this));
        this.isPlaying = true;
      },
      pause() {
        this.player.pause();
        this.isPlaying = false;
      },
      next() {
        this.index++;
        if (this.index > this.songs.length - 1) {
          this.index = 0;
        }
        this.current = this.songs[this.index];
        this.play(this.current);
      },
      prev() {
        this.index--;
        if (this.index < 0) {
          this.index = this.songs.length - 1;
        }
        this.current = this.songs[this.index];
        this.play(this.current);
      }
    },
    created() {
      axios.get('http:localhost:8098/api/songs/getSongFileName/' + '62717d55ae7539360f5e1c9e').then(resonse => {
          this.title = resonse.title,
          this.src = 'https://storage.yandexcloud.net/musicarchiveobjectstorage/' + resonse.fileName
          console.log(resonse)
        });
      this.current = this.songs[this.index];
      this.player.src = this.current.src;
    }
  }
</script>