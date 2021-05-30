module.exports = {
    pages: {
      index: {
        // entry for the page
        entry: './src/pages/Home/main.js',
        // the source template
        template: 'public/index.html',
        // output as dist/index.html
        // when using title option,
        // template title tag needs to be <title><%= htmlWebpackPlugin.options.title %></title>
        title: 'Home',
        // chunks to include on this page, by default includes
        // extracted common chunks and vendor chunks.
        chunks: ['chunk-vendors', 'chunk-common', 'index']
      },
      
      reservation_selecting: { 
        entry: './src/pages/Reservation_Selecting/main.js',
        // the source template
        template: 'public/index.html',
        // output as dist/index.html
        // when using title option,
        // template title tag needs to be <title><%= htmlWebpackPlugin.options.title %></title>
        title: 'Reservation - Selecting',
        // chunks to include on this page, by default includes
        // extracted common chunks and vendor chunks.
        chunks: ['chunk-vendors', 'chunk-common', 'reservation_selecting']
      },

      sign_in: {
        entry: './src/pages/Sign_In/main.js',
        // the source template
        template: 'public/index.html',
        // output as dist/index.html
        // when using title option,
        // template title tag needs to be <title><%= htmlWebpackPlugin.options.title %></title>
        title: 'Sign In',
        // chunks to include on this page, by default includes
        // extracted common chunks and vendor chunks.
        chunks: ['chunk-vendors', 'chunk-common', 'sign_in']
      }
    }
  }