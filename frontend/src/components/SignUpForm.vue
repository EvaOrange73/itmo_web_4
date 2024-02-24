<template>
  <div id="sign_up">
    <input type="text" name="username" placeholder="Имя" v-model="name" :class="name_error">
    <input type="password" name="password" placeholder="Пароль" v-model="password" :class="password_error">
    <input type="password" name="password_2" placeholder="Повторите пароль" v-model="password2" :class="password2_error">
    <input type="submit" value="Зарегистироваться" v-on:click="sign_up">
  </div>
</template>

<script>
export default {
  name: 'SingIn',
  data() {
    return {
      name: '',
      password: '',
      password2: '',
      name_error: '',
      password_error: '',
      password2_error: ''
    }
  },
  methods: {
    sign_up() {
      this.name_error = '';
      this.password_error = '';
      this.password2_error = '';
      let validation = true;
      if(!this.name){
        validation=false;
        this.name_error = 'error';
      }
      if(!this.password){
        validation=false;
        this.password_error = 'error';
      }
      if(!this.password2){
        validation=false;
        this.password2_error = 'error';
      }
      if (this.password !== this.password2) {
        validation = false;
        this.password_error = 'error';
        this.password2_error = 'error';
      }
      if (validation){
        this.$root.sign_up(this.name, this.password);
      }
    }
  }
}
</script>

<style>
@import "../../styles/form.css";
</style>