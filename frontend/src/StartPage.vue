<template>
  <div class="mid">
    <div class="container">
      <TwoForms
          :default_form="this.default_form"
          :wrong_password="this.wrong_password"
          :username_taken="this.username_taken"
          :successful_registration="this.successful_registration"
      />
    </div>
  </div>
</template>

<script>
import TwoForms from "@/components/forms/TwoForms.vue";

export default {
  name: 'Login',
  components: {TwoForms},
  data() {
    return {
      default_form: true, //true - sign in; false - sign up
      wrong_password: false,
      username_taken: false,
      successful_registration: false
    }
  },
  methods: {
    sign_in(username, password) {
      const data = new URLSearchParams();
      data.append('username', username);
      data.append('password', password);
      fetch('/sign-in', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: data
      }).then(response => {
            if (response.redirected) {
              window.location.replace(response.url);
            }
          }
      )
    },
    sign_up(username, password) {
      let json = JSON.stringify({
        username: username,
        password: password
      });
      fetch('/sign-up', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: json
      }).then(response => {
            if (response.redirected) {
              window.location.replace(response.url);
            }
          }
      );
    }
  },
  beforeMount() {
    let urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('error')) {
      this.wrong_password = true;
    } else if (urlParams.has('fail')) {
      this.username_taken = true;
      this.default_form = false;
    } else if (urlParams.has('success')) {
      this.successful_registration = true;
    }
  }
}
</script>

<style scoped>
body {
  background-color: #5F87CF;
  min-width: 350px;
}

.mid {
  width: 350px;
  margin: 10px auto;
}

.container {
  background-color: white;
  border-radius: 5px;
  box-shadow: #1F3F77 5px 5px 5px;
  padding: 5px;
  margin: 10px;
  height: 100%;
}


</style>