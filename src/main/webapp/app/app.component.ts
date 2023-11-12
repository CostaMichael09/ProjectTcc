import Vue from 'vue';
import Component from 'vue-class-component';
import Ribbon from '@/core/ribbon/ribbon.vue';
import JhiFooter from '@/core/jhi-footer/jhi-footer.vue';
import JhiNavbar from '@/core/jhi-navbar/jhi-navbar.vue';
import LoginForm from '@/account/login-form/login-form.vue';

import '@/shared/config/dayjs';
import VueCurrencyInput from 'vue-currency-input';

import Pdf from '@/component/pdf/pdf.vue'
import Img from '@/component/img/img.vue'
Vue.component('pdf', Pdf);
Vue.component('img-component', Img);

Vue.use(VueCurrencyInput, {
  globalOptions: {
    locale: 'pt-BR',
    distractionFree: false,
  },
});

import VueCurrencyFilter from 'vue-currency-filter';
Vue.use(VueCurrencyFilter, {
  symbol: 'R$',
  thousandsSeparator: '.',
  fractionCount: 2,
  fractionSeparator: ',',
  symbolPosition: 'front',
  symbolSpacing: true,
});
@Component({
  components: {
    ribbon: Ribbon,
    'jhi-navbar': JhiNavbar,
    'login-form': LoginForm,

    'jhi-footer': JhiFooter,
  },
})
export default class App extends Vue {}
