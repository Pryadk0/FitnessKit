package com.pryadko.fitnesskit.features.schedule.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.pryadko.fintesskit.core.presentation.viewmodel.ViewModelFactory
import com.pryadko.fitnesskit.features.schedule.databinding.FragmentScheduleBinding
import com.pryadko.fitnesskit.features.schedule.di.component.ScheduleComponentDependencies
import com.pryadko.fitnesskit.features.schedule.di.component.ScheduleComponentDependenciesProvider
import com.pryadko.fitnesskit.features.schedule.di.component.ScheduleComponentViewModel
import com.pryadko.fitnesskit.features.schedule.presentation.adapters.LessonsListAdapter
import javax.inject.Inject


class ScheduleFragment : Fragment() {
    private var _binding: FragmentScheduleBinding? = null
    private val binding: FragmentScheduleBinding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")

    private lateinit var viewModel: ScheduleViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var lessonsListAdapter: LessonsListAdapter

    override fun onAttach(context: Context) {
        val componentDependencies: ScheduleComponentDependencies =
            (context.applicationContext as ScheduleComponentDependenciesProvider).getScheduleComponentDependencies()
        ViewModelProvider(this)[ScheduleComponentViewModel::class.java]
            .newScheduleComponent(componentDependencies)
            .injectScheduleFragment(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewSchedule.adapter = lessonsListAdapter
        viewModel = ViewModelProvider(this, viewModelFactory)[ScheduleViewModel::class.java]
        viewModel.lessonsListLiveData.observe(viewLifecycleOwner) {
            lessonsListAdapter.submitList(it)
        }
        viewModel.lessonsListErrorLiveData.observe(viewLifecycleOwner) {
            if (lessonsListAdapter.currentList.isEmpty())
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }


}