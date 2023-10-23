/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import CarroComponent from '@/entities/carro/carro.vue';
import CarroClass from '@/entities/carro/carro.component';
import CarroService from '@/entities/carro/carro.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Carro Management Component', () => {
    let wrapper: Wrapper<CarroClass>;
    let comp: CarroClass;
    let carroServiceStub: SinonStubbedInstance<CarroService>;

    beforeEach(() => {
      carroServiceStub = sinon.createStubInstance<CarroService>(CarroService);
      carroServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<CarroClass>(CarroComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          carroService: () => carroServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      carroServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllCarros();
      await comp.$nextTick();

      // THEN
      expect(carroServiceStub.retrieve.called).toBeTruthy();
      expect(comp.carros[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
