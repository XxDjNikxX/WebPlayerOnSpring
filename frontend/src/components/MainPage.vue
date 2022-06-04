<template>
  <section class="player">
    <div class="w-full font-body">
      <div class="flex items-center justify-center h-screen bg-whie bg-indigo-200 dark:bg-indigo-400">
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
                  <svg class="w-8" xmlns="http://www.w3.org/2000/svg"
                    xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 20 20">
                    <path class="st0" d="M20.5,10.26l-20,10.53l0-20L20.5,10.26z"/>
                  </svg>
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
              <p>{{current.currentTime}}</p>
              <p>{{current.duration}}</p>
            </div>
            <div class="mt-1">
              <div @click="seek" class="h-1  rounded-full  bg-gradient-to-r from-slate-500 bg-indigo-600">
                <div   class="w-1/5 h-1 bg-red-light rounded-full relative">
                  <div :style="{ width: this.percentComplete + '%' }" 
                    class="w-4 h-4 bg-indigo-900 absolute pin-r pin-b -mt-1 rounded-full shadow dark:bg-white hover:bg-indigo-400 transition duration-300"></div>
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
  import {
    AXIOS
  } from '../http-common/http-commons';
  
  export default {
    name: 'MainPage',
    data() {
      return {
        current: {},
        index: 0,
        isPlaying: false,
        songs:[{
          title: 'Song Player',
          artist: 'DjNik',
          src: 'https://storage.yandexcloud.net/musicarchiveobjectstorage/Юность в сапогах (Gachi Version) _ Гачимучи ремикс.mp3'
        }],
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

        this.player.addEventListener('timeupdate', function() {
          this.current.currentTime = this.setDuration(this.player.currentTime);
        }.bind(this));

        this.player.addEventListener('loadedmetadata', function() {
          this.current.duration = this.setDuration(this.player.duration);
        }.bind(this));

        this.isPlaying = true;
      },
      seek(e) {
			const el = e.target.getBoundingClientRect();
			const seekPos = (e.clientX - el.left) / el.width;

			this.player.currentTime = parseInt(this.player.duration * seekPos);
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
      },
      setDuration : function(currentDuration) {
          var seconds = Math.round(currentDuration);
          var minutes = Math.floor(seconds / 60);
          minutes = (minutes >= 10) ? minutes : "0" + minutes;
          
          seconds = Math.floor(seconds % 60);
          seconds = (seconds >= 10) ? seconds : "0" + seconds;
          return minutes + ":" + seconds;
      },
    },
    created() {
      AXIOS.get('/getAllSongs').then(response => {
        response.forEach(function(item) {
          this.songs.push(item);
        });
      });
    }
}
</script>