import axios from 'axios'

export const AXIOS = axios.create({
  baseURL: 'https://ruiner-player.herokuapp.com/',
})