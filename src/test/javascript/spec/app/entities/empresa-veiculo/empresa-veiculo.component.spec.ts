/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import EmpresaVeiculoComponent from '@/entities/empresa-veiculo/empresa-veiculo.vue';
import EmpresaVeiculoClass from '@/entities/empresa-veiculo/empresa-veiculo.component';
import EmpresaVeiculoService from '@/entities/empresa-veiculo/empresa-veiculo.service';

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
  describe('EmpresaVeiculo Management Component', () => {
    let wrapper: Wrapper<EmpresaVeiculoClass>;
    let comp: EmpresaVeiculoClass;
    let empresaVeiculoServiceStub: SinonStubbedInstance<EmpresaVeiculoService>;

    beforeEach(() => {
      empresaVeiculoServiceStub = sinon.createStubInstance<EmpresaVeiculoService>(EmpresaVeiculoService);
      empresaVeiculoServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<EmpresaVeiculoClass>(EmpresaVeiculoComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          empresaVeiculoService: () => empresaVeiculoServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      empresaVeiculoServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllEmpresaVeiculos();
      await comp.$nextTick();

      // THEN
      expect(empresaVeiculoServiceStub.retrieve.called).toBeTruthy();
      expect(comp.empresaVeiculos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
