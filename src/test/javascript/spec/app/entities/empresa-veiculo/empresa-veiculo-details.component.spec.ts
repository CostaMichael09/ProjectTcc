/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import EmpresaVeiculoDetailComponent from '@/entities/empresa-veiculo/empresa-veiculo-details.vue';
import EmpresaVeiculoClass from '@/entities/empresa-veiculo/empresa-veiculo-details.component';
import EmpresaVeiculoService from '@/entities/empresa-veiculo/empresa-veiculo.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('EmpresaVeiculo Management Detail Component', () => {
    let wrapper: Wrapper<EmpresaVeiculoClass>;
    let comp: EmpresaVeiculoClass;
    let empresaVeiculoServiceStub: SinonStubbedInstance<EmpresaVeiculoService>;

    beforeEach(() => {
      empresaVeiculoServiceStub = sinon.createStubInstance<EmpresaVeiculoService>(EmpresaVeiculoService);

      wrapper = shallowMount<EmpresaVeiculoClass>(EmpresaVeiculoDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { empresaVeiculoService: () => empresaVeiculoServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundEmpresaVeiculo = { id: 123 };
        empresaVeiculoServiceStub.find.resolves(foundEmpresaVeiculo);

        // WHEN
        comp.retrieveEmpresaVeiculo(123);
        await comp.$nextTick();

        // THEN
        expect(comp.empresaVeiculo).toBe(foundEmpresaVeiculo);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEmpresaVeiculo = { id: 123 };
        empresaVeiculoServiceStub.find.resolves(foundEmpresaVeiculo);

        // WHEN
        comp.beforeRouteEnter({ params: { empresaVeiculoId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.empresaVeiculo).toBe(foundEmpresaVeiculo);
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
