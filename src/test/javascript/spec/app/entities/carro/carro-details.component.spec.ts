/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import CarroDetailComponent from '@/entities/carro/carro-details.vue';
import CarroClass from '@/entities/carro/carro-details.component';
import CarroService from '@/entities/carro/carro.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Carro Management Detail Component', () => {
    let wrapper: Wrapper<CarroClass>;
    let comp: CarroClass;
    let carroServiceStub: SinonStubbedInstance<CarroService>;

    beforeEach(() => {
      carroServiceStub = sinon.createStubInstance<CarroService>(CarroService);

      wrapper = shallowMount<CarroClass>(CarroDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { carroService: () => carroServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCarro = { id: 123 };
        carroServiceStub.find.resolves(foundCarro);

        // WHEN
        comp.retrieveCarro(123);
        await comp.$nextTick();

        // THEN
        expect(comp.carro).toBe(foundCarro);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCarro = { id: 123 };
        carroServiceStub.find.resolves(foundCarro);

        // WHEN
        comp.beforeRouteEnter({ params: { carroId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.carro).toBe(foundCarro);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
