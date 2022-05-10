const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8098', // this configuration needs to correspond to the Spring Boot backends' application.properties server.port
        ws: true,
        changeOrigin: true
    },
  },
  transpileDependencies: true,
  outputDir: 'target/dist',
  assetsDir: 'static'
})
