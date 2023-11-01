<template>
  <div class="home row">
    <div class="col-md-9">
      <h1 class="display-4" v-html="$t('home.title')">Welcome</h1>
      <div>
        <div class="alert alert-warning" v-if="!authenticated">
          <span v-text="$t('global.messages.info.authenticated.prefix')">If you want to </span>
          <a class="alert-link" v-on:click="openLogin()" v-text="$t('global.messages.info.authenticated.link')">sign in</a
          ><span v-html="$t('global.messages.info.authenticated.suffix')"
            >, you can try the default accounts:<br />- Administrator (login="admin" and password="admin") <br />- User (login="user" and
            password="user").</span
          >
        </div>
        <div class="alert alert-warning" v-if="!authenticated">
          <span v-text="$t('global.messages.info.register.noaccount')">You don't have an account yet?</span>&nbsp;
          <router-link class="alert-link" to="/register" v-text="$t('global.messages.info.register.link')"
            >Register a new account</router-link
          >
        </div>
      </div>

      <p v-text="$t('home.question')">If you have any question on JHipster:</p>

      <ul>
        <li>
          <a
            href="https://www.linkedin.com/in/michael-costa-3a3633144/"
            target="_blank"
            rel="noopener noreferrer"
            v-text="$t('home.link.linkedinMichael')"
            >LinkeDin do Michael</a
          >
        </li>
        <li>
          <a
            href="https://www.linkedin.com/in/camposwenderson/"
            target="_blank"
            rel="noopener noreferrer"
            v-text="$t('home.link.linkedinWenderson')"
            >LinkeDin do Wenderson</a
          >
        </li>
        <li>
          <a
            href="https://www.linkedin.com/in/vin%C3%ADcius-lima-b8a1b9165/"
            target="_blank"
            rel="noopener noreferrer"
            v-text="$t('home.link.linkedinVinicius')"
            >LinkeDin do Vinicius</a
          >
        </li>
      </ul>

      <p>
        <span v-text="$t('home.like')">If you like AgileKip Generator, don't forget to give us a star on</span>
        <a href="https://github.com/CostaMichael09/ProjectTcc" target="_blank" rel="noopener noreferrer" v-text="$t('home.github')"
          >GitHub</a
        >!
      </p>
    </div>
  </div>
</template>

<script lang="ts" src="./home.component.ts"></script>
